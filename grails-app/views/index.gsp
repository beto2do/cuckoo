<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Cuckoo App</title>

    <asset:link rel="icon" href="cuckoo.png" type="image/png" />
</head>
<body>
    <div id="container">
      <div class="row">
        <div class="col-md-3">
          <h1>Entrada</h1>
          <input id="clock"/>
        </div>
        <div class="col-md-9">
          <h1>Backlog</h1>
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
