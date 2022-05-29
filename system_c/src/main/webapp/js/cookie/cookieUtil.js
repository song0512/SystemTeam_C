/**
 * 쿠기 조작 함수 정의
 */
 
 const setCookie = function(name,value, period, path){
    let date = new Date();
    date.setDate(date.getDate() + period);
    let Cookie = `${name}=encodeURIComponent(${value});Expires=${date.toUTCString()};path=${path}`
    document.cookie = Cookie;
}
 
 const getCookie = function (name){
    let value = document.cookie.match(`(^|;) ?${name}=([^;]*)(;|$)`);
    return value ? value[2] : null;
}
 
const delCookie = function (name, path){
    let date = new Date();
    date.setDate(date.getDate() - 100);
    let Cookie = `${name}=;Expires=${date.toUTCString()};path=${path}`
    document.cookie = Cookie;
}