// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require kendo.all.min
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

window.CuckooComponent = function (options){
  "use strict";
  var config = {
    tmplId: "soundOutputTemplate",
    outputId: "outputContainer",
    getOutputUrl: "getOutputUrl"
  };
  var outside = {};

  var getTwentyFourFormat = function(date){
    return kendo.toString(date, "HH:mm");
  };

  var getOutputToShow = function(date) {
    $.ajax({
      type: "POST",
      url: config.getOutputUrl,
      dataType: "json",
      data: {date:date},
      success: function(sounds){
        var hour = getTwentyFourFormat(date);
        drawHours({hour:hour,sounds: sounds.msg});
      },
      error: function() {
        console.error("server error");
      }
    });
  };

  var drawHours = function(data) {
    var template = kendo.template($("#" + config.tmplId).html());
    var result = template(data);
    $("#" + config.outputId).append(result);
  };

  var createKendoDateTimePicker = function(){
    $("#clock").kendoDateTimePicker({
        timeFormat: "HH:mm",
        format: "HH:mm",
        interval: 1,
        change: function() {
            var date = this.value();
            getOutputToShow(date);
        }
    });
  };

  var init = function(){
    createKendoDateTimePicker();
  };

  $.extend( config, options );
  init();
  return outside;
}
