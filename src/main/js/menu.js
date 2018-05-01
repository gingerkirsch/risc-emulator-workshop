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
                    click: function() { events.emit('loadFile'); }
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
                    click: () => events.emit('openHelpWindow')
                }
            ]
        },
        {
            label: 'Run',
            submenu: [
                {
                    label: 'Run',
                    click: () => events.emit('executeRun')
                },
                {
                    label: 'Debug / Step',
                    click: () => events.emit('doStep')
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