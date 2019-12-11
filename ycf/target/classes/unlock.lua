local a = 0
for i=1,ARGV[1] do
    if redis.call('get', KEYS[i])==ARGV[i+1] then
        redis.call('del', KEYS[i])
        a = a+1
    end
end
return a