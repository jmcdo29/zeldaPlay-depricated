module.exports = {
  logExceptOnTest: function(string) {
    if (process.env.NODE_ENV !== "test") {
      console.log(string);
    }
  }
};