<h2 align='center'>

<img src="https://github.com/StamTsag/speedy/blob/master/.github/assets/preview.png" alt='Speedy preview'>
  
</h2>

## How it works

Speedy fetches the coordinates of the client, compares all available server coordinates to client coordinates in order to find the closest one using [haversine](https://en.wikipedia.org/wiki/Haversine_formula) formula then fetches a 100MB/1GB test file in order to check latency & download speed.

## Servers

- Los Angeles, US
- San Jose, US
- Phoenix, US
- Las Vegas, US
- Monticello, US
- Seattle, US
- Denver, US
- Ashburn, US
- Dallas, US
- Chicago DC1, US
- Chicago DC2, US
- Bend, US
- Jacksonville, US
- Buffalo, US
- Atlanta, US
- Kansas City, US
- Toronto, Canada
- Amsterdam, Netherlands
- Paris, France
- Frankfurt, Germany
- Coventry, United Kingdom
- Manchester, United Kingdom
- Bucharest, Romania
- Sofia, Bulgaria
- Tokyo DC1, Japan
- Singapore DC1, Singapore
- Singapore DC2, Singapore
- Hong Kong DC2, Hong Kong
- Hanoi, Vietnam
- Ho Chi Minh, Vietnam

## Running

- Install Docker

- `docker build -t speedy .` at the root of the project

- `docker run -p 8080:8080 speedy` will start the API at port `8080`
