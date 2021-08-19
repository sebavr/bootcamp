//Devuelve la suma de 1 a N. Por ejemplo,  Sum1toN(3) devolverá la suma de 1+2+3, la cual es 6
//sum1toN(255) devuelve la suma de todos los números de 1 a 255
function Sum1toN(n) {
    var suma = 0;
    for (let i = 1; i <= n; i++) {
        suma += i;
    }
    console.log("la suma de " + n + " es: " + suma)
    return suma;
}
//devuelve la suma del primer y último número en el array
function sumFirstLast(arr) {

    return arr[0] + arr[arr.length - 1];

}
//devuelva la suma del número más grande y el más pequeño del array. 
//Por ejemplo, sumMaxMin([1,3,10]) debería devolver 10 + 1 = 11, y sumMaxMin([-2,-5,-10]) 
//debería devolver -2 + -10 = -12

function sumMaxmin(arr) {
    let max = arr[0];
    let min = arr[0];
    for (let i = 0; i < arr.length; i++) {
        max = (arr[i] > max) ? arr[i] : max;
        min = (arr[i] < min) ? arr[i] : min;

    }
    return min + max;

}

describe("Sum1toN", function() {
    it("should return 3 when we pass 2 as an argument", function() {
        expect(Sum1toN(2)).toEqual(3);
    });
    it("should return 6 when we pass 3 as an argument", function() {
        expect(Sum1toN(3)).toEqual(6);
    });
    it("should return 10 when we pass 4 as an argument", function() {
        expect(Sum1toN(4)).toEqual(10);
    });
});

describe("sumFirstLast", function() {
    it("should return 3 when we pass [1,2] as an argument", function() {
        expect(sumFirstLast([1, 2])).toEqual(3);
    });
    it("should return 10 when we pass [2,3,8] as an argument", function() {
        expect(sumFirstLast([2, 3, 8])).toEqual(10);
    });
    it("should return -10 when we pass [-6,23,3,-4] as an argument", function() {
        expect(sumFirstLast([-6, 23, 3, -4])).toEqual(-10);
    });
});


describe("sumMaxmin", function() {
    it("should return 4 when we pass [1,2,3] as an argument", function() {
        expect(sumMaxmin([1, 2, 3])).toEqual(4);
    });
    it("should return 10 when we pass [3,2,8] as an argument", function() {
        expect(sumMaxmin([3, 2, 8])).toEqual(10);
    });
    it("should return -300 when we pass [100, 23, 3, -400] as an argument", function() {
        expect(sumMaxmin([100, 23, 3, -400])).toEqual(-300);
    });
});