$(document).on("submit", "form", function(e) {
	var button = $(this).find('button[type=submit]');
	button.prop('disabled', true);
	return true;
});