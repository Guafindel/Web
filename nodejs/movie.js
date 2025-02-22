//생성자 함수 정의 : 클래스 정의
function Movie(title, director){
    
    //변수 정의
    this.title = title;
    this.director = director;
    
    //메소드 정의
    this.showData = function() {
        console.log(this.title + ':' + this.director);
    };
    this.makeObj = function(){
        return {
            title : this.title,
            director : this.director
        };
    };
};

module.exports.Movie = Movie;
module.exports = Movie;