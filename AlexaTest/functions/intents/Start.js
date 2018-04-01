/**
* @param {string} name Intent Name (Automatically Populated by Handler)
* @returns {any}
*/
module.exports = (name = '', callback) => {

	return callback(null, 'This will respond to start command');

};