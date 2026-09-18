import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import groovy.json.JsonSlurper

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
try {
    WebUI.navigateToUrl('https://cstn.stjude.cloud/search/')
    WebUI.waitForPageLoad(30)
    WebUI.waitForElementPresent(findTestObject('Object Repository/SJCH Table Example/SJCH Results Table'), 30)

    String tableJson = WebUI.executeJavaScript('''
        return (function () {
            var root = document.querySelector('.sj-search-results .handsontable[id^="hot-"]');
            if (!root) return JSON.stringify({error: 'Results Handsontable was not found'});
            var master = root.querySelector('.ht_master');
            var instance = root.hotInstance || root.handsontable || (master && (master.hotInstance || master.handsontable));
            if (instance && typeof instance.getData === 'function') {
                var headers = [];
                for (var c = 0; c < instance.countCols(); c++) headers.push(String(instance.getColHeader(c) == null ? '' : instance.getColHeader(c)));
                var data = instance.getData(0, 0, instance.countRows() - 1, instance.countCols() - 1) || [];
                return JSON.stringify({headers: headers, data: data, source: 'Handsontable data model'});
            }
            var table = root.querySelector('.ht_master table.htCore');
            var headers = Array.from(table ? table.querySelectorAll('thead tr:first-child th') : []).map(function (x) { return x.innerText.trim(); });
            var data = Array.from(table ? table.querySelectorAll('tbody tr') : []).map(function (tr) {
                return Array.from(tr.children).map(function (td) { return td.innerText.trim(); });
            });
            var found = document.querySelector('.sj-search-results__found strong');
            var expectedRows = found ? parseInt(found.innerText.trim(), 10) : data.length;
            return JSON.stringify({headers: headers, data: data, expectedRows: expectedRows, source: 'rendered DOM'});
        }());
    ''', []) as String

    Map captured = (Map) new JsonSlurper().parseText(tableJson)
    assert !captured.error : captured.error
    List actualHeaders = (captured.headers ?: []).collect { it == null ? '' : it.toString().trim() }
    List actualRows = (captured.data ?: []).collect { row -> (row ?: []).collect { it == null ? '' : it.toString().trim() } }
    assert actualHeaders && actualRows : 'The results table contained no headers or rows.'
    if (captured.source == 'rendered DOM' && captured.expectedRows != actualRows.size()) {
        assert false : "Only ${actualRows.size()} rendered rows were captured, but the page reports ${captured.expectedRows}. The Handsontable data model was unavailable; refusing a partial comparison."
    }

    def sample = findTestData('Data Files/SJCH Example Spreadsheet/SJCH Sample')
    assert sample != null : 'SJCH Sample data file could not be loaded.'
    int sampleRows = sample.getRowNumbers()
    List sampleHeaders = sample.getColumnNames().collect { it == null ? '' : it.toString().trim() }
    List sampleData = (1..sampleRows).collect { r -> (1..sample.getColumnNumbers()).collect { c ->
        def value = sample.getValue(c, r)
        value == null ? '' : value.toString().trim()
    } }

    assert actualHeaders.size() == sampleHeaders.size() : "Column count mismatch: page=${actualHeaders.size()}, file=${sampleHeaders.size()}"
    assert actualRows.size() == sampleData.size() : "Row count mismatch: page=${actualRows.size()}, file=${sampleData.size()}"
    actualHeaders.eachWithIndex { value, c -> assert value == sampleHeaders[c] : "Header mismatch at column ${c + 1}: page='${value}', file='${sampleHeaders[c]}'" }
    actualRows.eachWithIndex { row, r ->
        assert row.size() == sampleData[r].size() : "Column count mismatch at row ${r + 1}: page=${row.size()}, file=${sampleData[r].size()}"
        row.eachWithIndex { value, c ->
            assert value == sampleData[r][c] : "Cell mismatch at row ${r + 1}, column ${c + 1} (${actualHeaders[c]}): page='${value}', file='${sampleData[r][c]}'"
        }
    }
    WebUI.comment("Verified ${actualRows.size()} rows x ${actualHeaders.size()} columns; every header and cell matches SJCH Sample.")
} finally {
    WebUI.closeBrowser()
}