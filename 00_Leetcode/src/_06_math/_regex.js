const str = '<p style="color: red;text-align: center; font-size: 18px; sss: ggg; kjkjkj: tester;">454 fgfgfg</p><p style="color: red;text-align: center; font-size: 18px; sss: ggg; kjkjkj: tester;">454 fgfgfg</p><p style="color: red;text-align: center; font-size: 18px; sss: ggg; kjkjkj: tester;"><a style="color: red;text-align: center; font-size: 18px; sss: ggg; kjkjkj: tester;"></a></p>';

/**
 * @param {string} str input string of tag
 * @param {string[]} accepts 
 * @returns {string} result filter of expected tag
 */
function extractInlineStyles(str, accepts=['color', 'text-align', 'font-size']) {
  if(!str.includes('style')) return str;
  
  return str.replace(/(style=\"?\'?([^\"]*)\"?\')/g, (...inlineStyles) => {
    const acceptsFinds = [];
    inlineStyles[2].split(';').filter(style => !!style).forEach(style => {
      if(accepts.includes(style.slice(0, style.indexOf(':')).trim())) {
        acceptsFinds.push(style);
      }
    });
    return `style="${acceptsFinds.join(';')};"`;
  });
}
console.log(extractInlineStyles(str));