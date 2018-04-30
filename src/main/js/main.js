const {app, Menu, BrowserWindow, dialog} = require('electron')

const path = require('path')
const url = require('url')
const {createMenu} = require('./menu')
const {registerObservers} = require('./EventManager');

function createMainWindow () {
    // Create the browser window.
    let mainWindow = new BrowserWindow({width: 724, height: 368});

    // and load the index.html of the app.
    mainWindow.loadURL(url.format({
      pathname: path.join(__dirname, './../Resources/index.html'),
      protocol: 'file:',
      slashes: true
  }));

    mainWindow.on('closed', function () {
        mainWindow = null
    });

    Menu.setApplicationMenu(createMenu())

    return mainWindow
}

const initApplication = () => {
    let mainWindow = createMainWindow();

    mainWindow.webContents.on('did-finish-load', () => {
        registerObservers(mainWindow)
    });

};

app.on('ready', initApplication);

// Quit when all windows are closed.
app.on('window-all-closed', function () {
    if (process.platform !== 'darwin') {
        app.quit()
    }
});

app.on('activate', function () {
    if (mainWindow === null) {
        createMainWindow()
    }
});

