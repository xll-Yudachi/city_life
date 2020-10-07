$(function () {
  $('.merge-city-job > h3 span').hover(function () {
    let index = $('.merge-city-job').find('h3 span').index($(this))
    $(this).siblings().removeClass("cur")
    $(this).addClass("cur")
    $($('.merge-city-job').find('ul')[index]).siblings().removeClass("cur")
    $($('.merge-city-job').find('ul')[index]).addClass("cur")
  }, function () {

  })
})
