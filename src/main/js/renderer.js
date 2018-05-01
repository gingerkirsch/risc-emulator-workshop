const {BackendApp} = require('./../../../target/scala-2.12/risc-emulator-fastopt');

const {ipcRenderer} = require('electron');


let currentAddress;

const Helper = {
    showReadValueForAddress: (address) => {
        currentAddress = address;
        document.getElementById("read-input-fieldset").classList.remove("disabled-input");
    },

    addDebug: (log) => {
        document.getElementById("dumpTextarea").innerText = log;
    },
    addOutput: (log) => {
        document.getElementById("outputTextarea").innerText = log;
    }
};

document.getElementById("submit-read-input").addEventListener("click", (event) => {
    const inputValue = document.getElementById("read-input").value;
    document.getElementById("read-input").value = "";
    document.getElementById("read-input-fieldset").classList.add("disabled-input");
    event.stopPropagation();
    BackendApp.setReadValue(currentAddress, inputValue);
});


window.Helper = Helper;

ipcRenderer.on("fileContentLoaded", function (event, fileContent) {
    document.getElementById("listing").innerText = fileContent;
    BackendApp.loadProgram(fileContent.split("\n").filter(e => e != "").map(e => parseInt(e)));
});

ipcRenderer.on("fileContentFailed", function (event, fileContent) {
    document.getElementById("listing").innerText = fileContent;
    BackendApp.loadProgram(fileContent);
});

ipcRenderer.on("callRunOnBackend", () => {
    BackendApp.run();
});

ipcRenderer.on("callGetDump", () => {
  document.getElementById("dumpTextarea").value = BackendApp.showDump()
});
