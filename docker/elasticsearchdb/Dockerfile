FROM docker.elastic.co/elasticsearch/elasticsearch:5.4.0

RUN bin/elasticsearch-plugin install http://dl.bintray.com/content/imotov/elasticsearch-plugins/org/elasticsearch/elasticsearch-analysis-morphology/5.4.0/elasticsearch-analysis-morphology-5.4.0.zip

ADD ./config /usr/share/elasticsearch/config

