require "prime"
require "set"

def concat_primes?(p1, p2)
  p1s, p2s = p1.to_s, p2.to_s
  (Prime.prime?((p1s+p2s).to_i) && Prime.prime?((p2s+p1s).to_i))
end

prime_sets = []

Prime.each do |prime|
  prime_sets << Set.new([prime])
  
  prime_sets.each do |set|
    if set.all? { |prime_in_set| concat_primes?(prime, prime_in_set) }
      prime_sets << Set.new(set.to_a << prime)
    end
  end

  first_prime = prime_sets.find { |set| set.size == 5 }
  if first_prime
    puts first_prime.to_a.join(" ")
    exit
    #break
  end
end

prime_sets.each do |set|
  puts set.to_a.join(" ")  
end
