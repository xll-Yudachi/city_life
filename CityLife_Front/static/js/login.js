$(function () {
  $('.sign-tab > span').click(function () {
    $(this).parents('.sign-form').css('display','none')
    $(this).parents('.sign-form').siblings().css('display','block')
    let curSpan = $(this)[0].className;
    $(this).parents('.sign-form').siblings().children(curSpan).addClass("cur")
    $(this).parents('.sign-form').siblings().children(curSpan).siblings().removeClass("cur")
  })
})
