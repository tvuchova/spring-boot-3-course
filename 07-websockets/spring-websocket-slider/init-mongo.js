db = db.getSiblingDB('admin');
db.createUser({
    user: "admin",
    pwd: "password",
    roles: [
        { role: "userAdminAnyDatabase", db: "admin" },
        { role: "readWrite", db: "rgbcolors" }
    ]
});

db = db.getSiblingDB('rgbcolors');
db.createCollection('rgb');
