function dec2bin(dec){
    var binary = (dec >>> 0).toString(2)
    while(binary.length < 36){
        binary = "0" + binary
    }
    return binary;
}

var bigArray = [100000]
bigArray.fill(0)

var fs = require('fs')
var textByChunk = fs.readFileSync('input.txt').toString().split("mask = ")
var textByLine = []
textByChunk.forEach(element => {
    var chunk = element.toString().split("\n")
    textByLine.push(chunk)
})

textByLine.forEach(element => {
    var mask = element.shift();
    
    element.forEach(elem => {
        var both = elem.toString().split("] = ");
        var address = both[0].replace("mem[", "")
        var number = dec2bin(both[1])
        var newNumber = "";
        for(var i = 0; i < number.length; i++)
        {
            if (mask.charAt(i) != 'X')
            {
                newNumber += mask.charAt(i)
            } else {
                newNumber += number.charAt(i)
            }
        }
        newNumber = parseInt(newNumber, 2)
        bigArray[address] = newNumber
    });
});

var result = 0
bigArray.forEach(element => {
    result = result + element
})

console.log(result);