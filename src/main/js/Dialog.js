const {dialog} = require("electron");

const selectFileDialog = (extension, name) => {
    return dialog.showOpenDialog({
                           properties: ['openFile'],
                           filters: [{
                               name: name,
                               extensions: [extension]
                           }]
                       })
};
const saveFileDialog = (extension, name) => {
    return dialog.showSaveDialog({
                           properties: ['openFile'],
                           filters: [{
                               name: name,
                               extensions: [extension]
                           }]
                       })
};

const showDialogMessage = (type, title, message) => {
    return dialog.showMessageBox({
                                type: type,
                                title: title,
                                message: message
                            });
};

module.exports = {
    selectFileDialog,
    saveFileDialog,
    showDialogMessage
};