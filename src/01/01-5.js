//ES6 클래스 사용 방법
class Shape {
    static create(x, y) {
        return new Shape(x, y);
    }
    name = 'Shape';
    constructor(x, y) {
        this.move(x, y);
    }
    move(x, y) {
        this.x = x;
        this.y = y;
    }
    area() {
        return 0;
    }
}

var s = new Shape(0, 0);
s.area();

class Circle extends Shape {
    constructor(x, y, radius) {
        super(x, y);
        this.radius = radius;
    }
    area() {
        if (this.radius === 0) return super.area();
        return this.radius * this.radius;
    }
}

var c = new Circle(0, 0, 10);
c.area();