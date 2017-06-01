function adjust_body_offset() {
    $('body').css('padding-top', $('.navbar-default').outerHeight(true) + 'px');
    $('body').css('padding-bottom', $('.navbar-fixed-bottom').outerHeight(true) + 'px');
}

$(window).resize(adjust_body_offset);

$(document).ready(adjust_body_offset);