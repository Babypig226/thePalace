/*! jQuery v1.11.3 | (c) 2005, 2015 jQuery Foundation, Inc. | jquery.org/license */
(function($) {
    $(function() {
       
       var   $window = $(window),
       $body = $('body'),
       $header = $('#header'),
       $banner = $('#banner');
       
       
       $('#hmenu')
       .append('<a href="#hmenu" class="close"></a>')
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