local a=0
for i=1,ARGV[1] do
    if redis.call('setNx',KEYS[i],ARGV[i+2]) then
         if redis.call('get',KEYS[i])==ARGV[i+2] then
             a=a+redis.call('expire',KEYS[i],ARGV[2])
        end
    end
end
if a==ARGV[1] then
    for i=1,ARGV[1] do
        if redis.call('get', KEYS[i])==ARGV[i+2] then
            redis.call('del', KEYS[i])
        end
    end
end
return a
