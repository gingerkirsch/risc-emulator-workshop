const {BrowserWindow} = require('electron'),
  path = require('path'),
  url = require('url');

const createHelpWindow = () => {
  let win = new BrowserWindow({width: 300, height: 380, autoHideMenuBar: true});

  win.webContents.on('did-finish-load', () => {
    win.show();
    win.focus()
  });

  win.on('closed', function () {
    win = null
  })

  win.loadURL(url.format({
    pathname: path.join(__dirname, './../Resources/help.html'),
    protocol: 'file:',
    slashes: true,
    fixed: false
  }));

  win.on('closed', function () {
    win = null
  });

  return win
};

module.exports = {
  createHelpWindow
};
