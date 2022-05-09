/**
This is short script to fetch user info from the data base and pars
the info to link and so on..
 */

function fetchLogin() {
    fetch("/getallusers", {
        headers: {
            'Content-Type': 'application/json'
        }})
        .then(res => res.json())
        .then(resp => {

            res = "";
            for (el of resp) {
                var row = "<tr><td><a target=\"_blank\" href=" + el.web + "> "+
                    el.name + "</td><td>" + el.count + " </a></td></tr>";
                res += row;

            };
            if (res == "") {
                res = "No Results"
            }
            document.getElementById("table-rows").innerHTML = res;

        })
        .catch(e => {
            document.getElementById("table-rows").innerHTML = "Some error occured!";
            /* some error in the data base, the cause is the session we will logout */
            window.location.href ='/clienterror'
        });
}
