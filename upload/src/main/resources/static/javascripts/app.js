$(function() {
	var settings = {
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)'
	};
	
	UIkit.uploadSelect($('#upload-select'), settings);
	UIkit.uploadDrop($('#upload-drop'), settings);
});