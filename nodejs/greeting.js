//모듈 생성
module.exports.hi = function(){
    console.log('Hi~!!');
};

//모듈함수 생성 : module 생략
exports.bye = function(arg, callback){
    console.log('Bye~!!');
};