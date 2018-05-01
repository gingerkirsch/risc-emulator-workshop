const {dialog} = require("electron");

const selectFileDialog = (extension, name) => {
    /* implement show open dialog*/
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