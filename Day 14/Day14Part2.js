function dec2bin(dec){
    var binary = (dec >>> 0).toString(2)
    while(binary.length < 36){
        binary = "0" + binary
    }
    return binary;
}

var bigArray = [10000000]
bigArray.fill(0)

var fs = require('fs')
var textByChunk = fs.readFileSync('testinp.txt').toString().split("mask = ")
var textByLine = []
textByChunk.forEach(element => {
    var chunk = element.toString().split("\n")
    textByLine.push(chunk)
})
console.log(textByLine.length)

function xChecker(address, value){
    if (address.includes('X')) {
        xChecker(address.replace('X', "0"), value)
        xChecker(address.replace('X', "1"), value)
    } else {
        address = parseInt(address, 2)
        bigArray[address] = value
    }
}

textByLine.forEach(element => {
    var mask = element.shift();
    
    element.forEach(elem => {
        var both = elem.toString().split("] = ");
        var address = dec2bin(both[0].replace("mem[", ""))
        var number = parseInt(both[1], 10)
        var newAddress = "";
        for(var i = 0; i < address.length; i++)
        {
            if (mask.charAt(i) != '0')
            {
                newAddress += mask.charAt(i)
            } else {
                newAddress += address.charAt(i)
            }
        }
            xChecker(dec2bin(newAddress), number);
    });
});

var result = 0
bigArray.forEach(element => {
    result = result + element
})

console.log(result);