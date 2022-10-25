function foo() {
    console.log("foo");
}

fooo();

a.bar = 5

let a = { foo: 5 }

a.foo();

a.bar();

let b = null;

b.foo();

function callMe(o) {
    return o();
}

callMe(null)