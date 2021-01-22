var fs = require('fs')
var textByLine = fs.readFileSync('input.txt').toString().split("\n")
var timeStamp = textByLine[0]
var busTimes = textByLine[1].toString().replace(/,x/g, "")
var busTimesArr = busTimes.split(",")
var busWaitTime = [];
busTimesArr.forEach(element => {
    busWaitTime.push(Math.ceil(timeStamp/element)*element-timeStamp)
});

const findLeast = (number) => number == Math.min(...busWaitTime)
var bestBus = busTimesArr[busWaitTime.findIndex(findLeast)]

console.log(bestBus*Math.min(...busWaitTime));