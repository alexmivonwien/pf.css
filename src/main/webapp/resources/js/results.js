function jsOnResizeAction(){
	window.addEventListener('resize', onresize);
}


// @see https://stackoverflow.com/questions/1235985/attach-a-body-onload-event-with-js/12460803
//Dean Edwards/Matthias Miller/John Resig
function init() {
  // quit if this function has already been called
  if (arguments.callee.done) return;

  // flag this function so we don't do the same thing twice
  arguments.callee.done = true;

  // kill the timer
  if (_timer) clearInterval(_timer);

  // do stuff
  onresize();
};

/* for Mozilla/Opera9 */
if (document.addEventListener) {
  document.addEventListener("DOMContentLoaded", init, false);
}

/* for Internet Explorer */
/*@cc_on @*/
/*@if (@_win32)
  document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
  var script = document.getElementById("__ie_onload");
  script.onreadystatechange = function() {
    if (this.readyState == "complete") {
      init(); // call the onload handler
    }
  };
/*@end @*/

/* for Safari */
if (/WebKit/i.test(navigator.userAgent)) { // sniff
  var _timer = setInterval(function() {
    if (/loaded|complete/.test(document.readyState)) {
      init(); // call the onload handler
    }
  }, 10);
}

/* for other browsers */
window.onload = init;

function onresize (event){
    var width = document.documentElement.clientWidth;
    var height = document.documentElement.clientHeight;
    
    var resultsFormHeight = document.getElementById("resultsFormId:heightId");
    if (resultsFormHeight){
    	resultsFormHeight.value= height;
    }
    
    var resultsFormWidth = document.getElementById("resultsFormId:widthId");
    if (resultsFormWidth){
    	resultsFormWidth.value = width;
    }
    
    if (resultsFormWidth || resultsFormHeight){
    	setScreenSize();
    }
}