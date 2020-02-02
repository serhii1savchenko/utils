javascript:try {
    a = window.shz.app
} catch (error) {
    alert('Sorry, This link works ONLY in Shazam tab.')
}
;
if (a) {
    d = document;
    b = a.origin + '/discovery/v4/' + a.language + '/' + a.country + '/web/-/tag/' + a.inid + '?limit=' + 1000;
    c = d.createElement('a');
    c.download = 'myShazam.json';
    c.href = b;
    c.click();
    ;d.body.innerHTML = "<h1 style='color:black'>Downloading...</h1>"
}
;void (0);