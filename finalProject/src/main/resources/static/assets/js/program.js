(function($) {
	$(function() {
		
		var	$window = $(window),
		$body = $('body'),
		$header = $('#header'),
		$banner = $('#banner');
		
		
		$('#Programnav')
		.append('<a href="#Programnav" class="close"></a>')
		.appendTo($body)
		.panel({
			delay: 500,
			hideOnClick: true,
			hideOnSwipe: true,
			resetScroll: true,
			resetForms: true,
			side: 'right'
		});
		
	})
})(jQuery);