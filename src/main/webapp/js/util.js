var contextPath = getContextPath();

function getContextPath() {
	var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var appName = pathName.substr(0,index+1);
    var contextPath = document.location.origin + appName + '/';
	return contextPath;
}
