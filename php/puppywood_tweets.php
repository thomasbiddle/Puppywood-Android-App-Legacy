<?php

require_once('TwitterAPIExchange.php');
require_once('Spyc.php');

$tokens = Spyc::YAMLLoad('config.yaml');

$settings = array(
    'oauth_access_token' => $tokens['access_token'],
    'oauth_access_token_secret' => $tokens['access_token_secret'],
    'consumer_key' => $tokens['consumer_key'],
    'consumer_secret' => $tokens['consumer_key_secret']
);

$url = 'https://api.twitter.com/1.1/statuses/user_timeline.json';
$getfield = '?screen_name=puppywood';
$requestMethod = 'GET';

$twitter = new TwitterAPIExchange($settings);
echo $twitter->setGetfield($getfield)
             ->buildOauth($url, $requestMethod)
             ->performRequest();

?>

