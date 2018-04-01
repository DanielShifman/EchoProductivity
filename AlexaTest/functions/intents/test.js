/**
* @param {string} name Intent Name (Automatically Populated by Handler)
* @param {object} slots Slot Information, {name, value}
* @returns {any}
*/
module.exports = (name = '', slots = {}, callback) => {

  return callback(null, `Hello World`);

};