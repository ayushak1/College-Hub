package app.tutorbyte.helper

class Constants {
    companion object {
        fun getPDFHtml(url: String): String {
            return """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
                    <style>
                        body, html {
                            margin: 0;
                            height: 100%;
                            overflow: hidden;
                        }
                        iframe {
                            position: absolute;
                            top: 0;
                            left: 0;
                            width: 100%;
                            height: 100%;
                            border: none;
                        }
                    </style>
                </head>
                <body>
                    <iframe src="$url" allow="autoplay"></iframe>
                </body>
                </html>
            """
        }
    }

    object AppState {
        var cnt = 0
    }
    object myVarReal{
        var st = "USER"
    }
}
