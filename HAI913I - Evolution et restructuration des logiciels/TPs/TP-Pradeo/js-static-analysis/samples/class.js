class A {
    foo() {
      console.log("A.foo");
    }
}

class B extends A {
    foo() {
        console.log("B.foo");

        this.bar();
    }

    bar() {
        console.log("B.bar");

        foo();
    }
}

class C {
    foo() {
        console.log("C.foo");
    }
}

const a = new A();

a = 52;

a.foo();
a.bar();

const c = new C();

c.foo();