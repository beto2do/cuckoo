<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Cuckoo App</title>

    <asset:link rel="icon" href="cuckoo.png" type="image/png" />
</head>
<body>
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <h1>Input</h1>
          <input id="clock"/>
          <div id="spinner" class="spinner" style="display:none;">
              <g:message code="spinner.alt" default="Loading&hellip;"/>
          </div>
        </div>
        <div class="col-md-9">
          <h1>Output</h1>
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Hours</th>
                <th>Sound</th>
              </tr>
            </thead>
            <tbody id="outputContainer"></tbody>
          </table>
        </div>
      </div>
    </div>
    <script id="soundOutputTemplate" type="text/x-kendo-template">
        <tr>
          <th scope="row">#= data.hour #</th>
          <td>#= data.sounds #</td>
        </tr>
    </script>
</body>
</html>
