from flask import Flask, render_template, url_for, request
#from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
#database for the products that are up for a consortion
'''app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test.db'
db = SQLAlchemy(app)

class Products(db.Model):
    id = db.Column(db.integer, primary_key=True)
    title = db.column(db.string(200), nullable=False)
    content = db.column(db.string(200), nullable=False)
    price = db.column(db.double, nullable=False)

    def __repr__(self):
        return '<Task %r>' % self.id
'''

@app.route("/", methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        return render_template('Ravi_Nayak_Task1_40349442.html', price=100)
    if request.method == 'POST':
        return render_template('proceed.html')

    return render_template('landingpage.html')


if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=80)