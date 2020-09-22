(function($) {
	$(function() {
		
		var	$window = $(window),
		$body = $('body'),
		$header = $('#header'),
		$banner = $('#banner');
		
		
		$('#Productnav')
		.append('<a href="#Productnav" class="close"></a>')
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