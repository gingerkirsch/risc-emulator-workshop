const {events} = require('./menu'),
    {createHelpWindow} = require('./Windows'),
    {selectFileDialog, saveFileDialog, showDialogMessage} = require('./Dialog'),
    {readFile, updateFile} = require('./IoOperations'),
    EventEmitter = require('events');

const emittedEvents = new EventEmitter();

let currentFilePath = null;

const registerObservers = (mainWindow) => {
    events.on("openHelpWindow", () => {
        /* implement open help window */
    });

    events.on("loadFile", () => {
        /* implement loadFile */
    });

    events.on("createNewFile", () => {
        const fileLocation = saveFileDialog("txt", "file that contains stuff");
        currentFilePath = fileLocation;
        updateFile(fileLocation, "").then(content => {
            console.log('successfully create content: ', content);
            mainWindow.webContents.send("newFileContentCreate", content)
        }, error => {
            console.log('failed to load content error: ', error);
            showDialogMessage("error", "file save failed", "the file could not be saved " + error.message);
            mainWindow.webContents.send("newFileContentFailed", error)
        })
    });

    events.on("saveFile", () => {
        if (currentFilePath === null) {
            showDialogMessage("error", "file save error", "You should load or create a file first")
        } else {
            updateFile(currentFilePath, "collect the content").then(content => {
                console.log('successfully create content: ', content);
                mainWindow.webContents.send("newFileContentCreate", content)
            }, error => {
                console.log('failed to load content error: ', error);
                mainWindow.webContents.send("newFileContentFailed", error)
            })
        }
    });

    events.on('executeRun', () => {
        mainWindow.webContents.send("callRunOnBackend")
    })

    events.on('getDump', () => {
        mainWindow.webContents.send("callGetDump")
    })

}


module.exports = {
    registerObservers,
    emittedEvents
};