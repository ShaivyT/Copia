"use strict";

// Time Complexity: O(M * N), where M is the size of map1 and N is the size of map2
// Space Complexity: O(1), constant space

// My Approach: 
// I am using checkObjEquality() function to iterate over the keys 
// of the objects and then equating them
// I thought about JSON.stringfy() as a solution but it is not a 
// good approach as the order being compared might not be the same

function compareMaps(map1, map2) {
    let testVal;
    let flag = false;
    if (map1.size !== map2.size) {
        return flag;
    }
    for(let [key, val] of map1) {
    	
      testVal = map2.get(key);
      
      if(typeof(testVal) === "object") {
      	flag = checkObjEquality(val, testVal);
      } else if(val === testVal) {
      	flag = true;
      } else {
      	flag = false;
      }
    }
    return flag;
}

function checkObjEquality(val, testVal) {

	for(let [objKey, objVal] of Object.entries(val)) {
    //console.log(objKey, objVal, testVal[key], testVal[objKey]);
    if(objVal !== testVal[objKey]) {
      return false;
    }
  }
  return true;
}

const map1 = new Map();
const map2 = new Map();

map1.set("key1", "value");
map1.set("key2", {"key 3": 1});

map2.set("key1", "value");
map2.set("key2", {"key 3": 1});

console.log(compareMaps(map1, map2));
