const WebUntis = require('webuntis');
require('dotenv').config();
const untis = new WebUntis('htl3r', process.env.LOGIN, process.env.PASSWORD, 'urania.webuntis.com');
const fs = require("fs")

untis
    .login()
    .then(() => {
        return untis.getOwnTimetableForToday();
    })
    .then((timetable) => {
        writeJSON(timetable);
    });

function writeJSON(timetable){
    const data = JSON.stringify(timetable)

    fs.writeFile("../files/JSON_Stunden/timetable.json", data, err=>{
        if(err){
            console.log("Error writing file", err)
        } else {
            console.log('JSON data is written to the file successfully')
        }
    })
}