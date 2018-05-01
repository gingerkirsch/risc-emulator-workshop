'use strict';

const {Menu} = require('electron'),
    EventEmitter = require('events');

const events = new EventEmitter();


const createMenu = () => {
    const template = [
        {
            label: 'Debug',
            submenu: [
                {label: 'Dev Tools', role: "toggledevtools"},
                {label: 'Force Reload', role: "forcereload"}
            ]
        },
        {
            label: 'File',
            submenu: [
                {
                    label: 'New',
                    click: function() { events.emit('createNewFile'); }
                },
                {
                    label: 'Open',
                    click: function() { /* add your code for load file */ }
                },
                {
                    label: 'Save',
                    click: function() { events.emit('saveFile'); }
                },
                {label: 'Exit', role: 'close'}
            ]
        },
        {
            label: 'View',
            submenu: [
                {
                    label: 'Help',
                    click: () => { /* add your code for help window */ }
                }
            ]
        },
        {
            label: 'Run',
            submenu: [
                {
                    label: 'Run',
                    click: () => { /* add your code for execute run */ }
                }
            ]
        },
        {
            role: 'stop',
            submenu: []
        }
    ];

    return Menu.buildFromTemplate(template);
}

module.exports = {
    createMenu,
    events
}