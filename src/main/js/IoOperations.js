const fs = require('fs')

const readFile = (fileName) => {

    return new Promise((resolve, reject) => {

        fs.readFile(fileName, 'utf-8', (err, data) => {
            if(err){
                reject(err)
            } else {
                resolve(data)
            }
        });
    });
}

const updateFile = (filepath, content) => {

    return new Promise((resolve, reject) => {
        fs.writeFile(filepath, content, (err) => {
            if (err) {
                reject(err)
            } else {
                resolve(content)
            }
        });
    });
}

module.exports = {
    readFile,
    updateFile
}