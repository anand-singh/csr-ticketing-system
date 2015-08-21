var ticketsDataTable = function () {

    var dt = $('#ticketsDataTable').DataTable({
        responsive: true,
        "columnDefs": [
            {"orderable": false, "targets": [0]},
            {"targets": [ 1 ], "visible": false}
        ],
        "order": [[ 6, "desc" ]]
    });

    // Array to track the ids of the details displayed rows
    var detailRows = [];

    $('#ticketsDataTable tbody').on('click', 'tr td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = dt.row(tr);
        var idx = $.inArray(tr.attr('id'), detailRows);

        if (row.child.isShown()) {
            tr.removeClass('details');
            row.child.hide();

            // Remove from the 'open' array
            //detailRows.splice( idx, 1 );
        } else {
            tr.addClass('details');
            var ticketId = row.data()[1];
            row.child(childRowDetails(ticketId)).show();

            populateRowDetails(ticketId);

            // Add to the 'open' array
            if (idx === -1) {
                detailRows.push(tr.attr('id'));
            }
        }
    });

    // On each draw, loop over the `detailRows` array and show any child rows
    dt.on('draw', function () {
        $.each(detailRows, function (i, id) {
            $('#' + id + ' td.details-control').trigger('click').trigger('click');
        });
    });

}

var childRowDetails = function (id) {
    return '<div id=rowDetails_' + id + '><div class="overlay"><i class="fa fa-refresh fa-spin"></i></div></div>'
}

var populateRowDetails = function (id) {
    var request = $.ajax({
        url: "/ticket-details?id=" + id,
        method: "GET",
        dataType: "html"
    });

    request.done(function (data) {
        $("#rowDetails_" + id).html(data);
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });
    });

    request.fail(function (jqXHR, textStatus) {
        $("#rowDetails_" + id).html(textStatus);
    });
}