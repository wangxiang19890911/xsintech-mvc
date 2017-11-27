var contextPath = $('#contextPath').val();
$(document).ready(function() {

	$('#btn-login').click(function() {
		location.href = contextPath + '/index'
	});

});